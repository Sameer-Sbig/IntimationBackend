package com.sbigeneral.Intimation.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbigeneral.Intimation.Entity.Agent;
import com.sbigeneral.Intimation.Entity.AgentDetails;
import com.sbigeneral.Intimation.Repository.AgentDetailsRepo;
import com.sbigeneral.Intimation.Repository.AgentRepo;
import com.sbigeneral.Intimation.Service.AgentDetailsService;
import com.sbigeneral.Intimation.Service.PolicyDetailsService;
import com.sbigeneral.Intimation.Util.ClientAgentAuthenticationToken;
import com.sbigeneral.Intimation.Util.JwtAgentDetailsService;
import com.sbigeneral.Intimation.Util.JwtRequest;
import com.sbigeneral.Intimation.Util.JwtTokenUtil;
import com.sbigeneral.Intimation.model.JwtResponseWithUser;

@RestController
@PropertySource("classpath:log4j2.properties")
public class AuthenticationController {
	
	@Autowired
	private AgentDetailsRepo agentMasterRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AgentRepo agentRepo;
	
	@Autowired
	private JwtAgentDetailsService agentDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AgentDetailsRepo agentDetailsRepo;
	
	@Autowired
	private AgentDetailsService agentDetailsServive;
	
	@Autowired
	private PolicyDetailsService policyDetailsService;
	
	private static final Logger logger = LogManager.getLogger(AuthenticationController.class);
	
	@PostMapping("/getClientId")
	public ResponseEntity<?> getClientId(@RequestBody Map<String,String> obj) {
		try {
			
			String agentId = obj.get("agentId");
			String clientId = UUID.randomUUID().toString();
			clientId = clientId.substring(0, 8);
			Map<String, String> clientID = new HashMap<String, String>();
			
			AgentDetails agent = new AgentDetails();
			agent.setAgentId(agentId);
			agent.setClientId(clientId);
			clientID.put("clientId", clientId);
			agentMasterRepo.save(agent);
			logger.info("Client id created against the agentID "+agentId);
			return new ResponseEntity<>(clientID,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error occured while creating client id ",e);
			return new ResponseEntity<>("Error occured while creating client id !",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/getToken")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest authenticationRequest) {
		try {
			System.out.println(authenticationRequest);
//			JwtRequest authenticationRequest = objectMapper.readValue(obj.toString(), JwtRequest.class);
			authenticate(authenticationRequest.getClientId(), authenticationRequest.getAgentId());
			Agent agent = agentRepo.findByClientId(authenticationRequest.getClientId());
			System.out.println("Agent is : "+agent);
			
			final UserDetails userDetails = agentDetailsService.loadUserByUsername(authenticationRequest.getClientId());
			final String token = jwtTokenUtil.generateToken(userDetails);
			
			agentDetailsRepo.storeToken(token, authenticationRequest.getClientId());
			
			JwtResponseWithUser response = new JwtResponseWithUser(token,authenticationRequest.getClientId(),authenticationRequest.getAgentId(),authenticationRequest.getSource(),authenticationRequest.getPolicyNo());
			
			AgentDetails loggedInAgent = agentDetailsServive.login(authenticationRequest.getClientId(), authenticationRequest.getAgentId());
			
			if(!authenticationRequest.getPolicyNo().equals("")) {
				Boolean flag1 = policyDetailsService.checkPolicyWithAgreementCode(authenticationRequest.getPolicyNo(), authenticationRequest.getAgentId());
				if(!flag1) {
					return new ResponseEntity<>("Not a valid policy against agreement code !",HttpStatus.NOT_FOUND);
				}
			}
			
			Boolean flag2 = agentDetailsServive.checkAgreementCodeWithClientId(authenticationRequest.getClientId(), authenticationRequest.getAgentId());
			if(!flag2) {
				return new ResponseEntity<>("Not a valid client id against agreement code !",HttpStatus.NOT_FOUND);
			}
			
			if(loggedInAgent != null) {
				return new ResponseEntity<>(response,HttpStatus.OK);
				
			} else {
				return new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private void authenticate(String clientId, String agentId) throws Exception {
		try {
			authenticationManager.authenticate(new ClientAgentAuthenticationToken(clientId, agentId));
		} catch (DisabledException e) {
			e.printStackTrace();
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@PostMapping("/logoutUser")
	public ResponseEntity<?> logout(@RequestBody Map<String,String> clientId) {
		try {
			System.out.println("Logout api");
			agentDetailsServive.logout(clientId.get("clientId"));
			return new ResponseEntity<>("Logout succesfully ",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}