package com.sbigeneral.PINS.ServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sbigeneral.PINS.Controller.loginController;
import com.sbigeneral.PINS.Entity.AgreementCodeEntity;
import com.sbigeneral.PINS.Entity.User;
import com.sbigeneral.PINS.Exception.AccountLockedException;
import com.sbigeneral.PINS.Exception.UserNotFoundException;
import com.sbigeneral.PINS.Repository.UserRepository;
import com.sbigeneral.PINS.Service.UserService;
import com.sbigeneral.PINS.Utill.GCMUtilty;
import com.sbigeneral.PINS.Utill.LoginAttemptService;

@Service
@PropertySource("classpath:sqlQuery.properties")
public class UserServiceImpl implements UserService ,UserDetailsService{
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private SessionFactory sessionfactory;
	
	@Value("${Erms.AgreementCodeDetails}")
	private String AgreementCode;
	@Autowired
	private LoginAttemptService loginattemptservice;

	private static final Logger logger=LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Lazy
	private PasswordEncoder encoder;
	@Autowired
	private GCMUtilty gcmUtility;
	private static String key="SGVsbG8gV29ybGQh";
	@Override
	public String SaveEmployeDetails(User user) {
		logger.info("save the user Details"+user);
		User user1 = new User();
		String userName="";
		Set<String> list1= new HashSet<String>();
		try {
		list1.add("ADMIN");
		list1.add("USER");
 		user1.setMobileNo(user.getMobileNo());
		user1.setEmail(user.getEmail());
 		//user1.setEmail("sinu@qworks.co");
		user1.setCreatedBy(user.getUsername());
		user1.setUsername(user.getUsername());
		user1.setRole(list1);
		user1.setPassword(encoder.encode(user.getPassword()));
		user1.setEncodePassword(user.getPassword());
		user1.setStatus(String.valueOf(1));
		Date date = new Date();
		DateFormat format1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String currentDate = format1.format(date);
		user1.setCreated_On(currentDate);
		userName = uRepo.save(user1).getUsername();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Internal server error occurred while save the employee  Page for username: {}",user1,  e);
		}
		logger.info(userName + "saved successfully");
		return userName + "saved successfully";
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * if(loginattemptservice.isBlocked(username)) { throw new
		 * AccountLockedException("Account isLocked",HttpStatus.LOCKED.value());
		 * 
		 * }
		 */
		Optional<User> user1 = uRepo.findByUsername(username);
		logger.info("finding the userName", user1);
		System.out.println(username);

		if (user1.empty() == null) {
			logger.error("user not found Exception", user1);
			throw new UserNotFoundException("user not found Exception");

		}
		User user = user1.get();
		logger.info("finding the userName details ", user);

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
				user.getRole().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
	}

	private String DecryptedPassword(String encryptPassword) {
		String encryptPassword1 = null;
		try {
			encryptPassword1 = gcmUtility.decryptGCM(encryptPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptPassword1;
	}

	@Override
	public User findByAgrementCode(String agrementcode) {
		logger.info("Finding the email details for agreement code: {}", agrementcode);

		User user = uRepo.findByUsername1(agrementcode);

		logger.info("User found: {}", user);

		return user;
	}




	@Override
	public List<AgreementCodeEntity> checkAgrementCodeExistOrNot(String agreementCode) {
		logger.info("Check the AgreementCode Exist or not"+agreementCode);
		Session session = this.sessionfactory.openSession();
		//logger.info("Get all RmS renewal report");
		List<AgreementCodeEntity> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		String agent_code=agreementCode;
		sql.append(this.AgreementCode
				.toString());
		SQLQuery query1 = session.createSQLQuery(sql.toString());
		try {
		query1.setParameter("agent_code", agent_code);
		logger.info(query1);
		List result = query1.list();
		ListIterator iterator = result.listIterator();
		
		while (iterator.hasNext()) {
			Object[] row = (Object[]) (Object[]) iterator.next();
			AgreementCodeEntity report = new AgreementCodeEntity();
			String flag = "";
			String flag1 = "";
			Date date = null;
			
			if (row[0] != null)
				report.setAgreementCode(row[0].toString());
			if (row[1] != null)
				report.setAgent_Name(row[1].toString());
			
			/*
			 * if (row[2] != null) report.setAGREEMENT_ID(row[2].toString()); if (row[3] !=
			 * null) report.setAGENT_ID(row[3].toString());
			 */
			 
			
			if (row[2] != null)
				report.setAgeentCreationDate(row[2].toString());
			if (row[3] != null)
				report.setMobileNo(row[3].toString());
			if (row[4] != null)			
				report.setEmailId(row[4].toString());
			if (row[5] != null)				
				report.setLicense_Expdate(row[5].toString());
			if (row[6] != null)				
				report.setStatus(row[6].toString());
			list.add(report);
		}
	session.close();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("while checking the agreementCode or exist or not internal server error"+e);
		}
	
	
	return list;




	

	}
	
	
	@Override
	public User FindByUserName(String username) {
		Optional<User> user = uRepo.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		}
		return null;

	}

	  @Transactional
		@Override
	    public void UpdatePassword(String username, String newPassword) throws Exception {
	        logger.info("Updating password for Username: {}", username);

	        // Fetch the user by username
	        User user = FindByUserName(username);
	        if (user == null) {
	            logger.error("User not found with Username: {}", username);
	            throw new Exception("User not found");
	        }

	        // Validate new password (example validation)
			/*
			 * if (newPassword.length() < 8) {
			 * logger.error("New password is too short for Username: {}", username); throw
			 * new Exception("Password must be at least 8 characters long"); }
			 */
	        // Hash the new password
	        String encodedPassword = encoder.encode(newPassword);

	        // Update the user's password
	        user.setEncodePassword(newPassword);
	        user.setPassword(encodedPassword);
	        user.setFlag("N");
	        uRepo.updateColumnsById(user.getUsername(), user.getEncodePassword(), user.getFlag(), user.getPassword());
	        logger.info("Password updated successfully for Username: {}", username);
	    }
	  
	  
	  @Override
	public void savePasswordFlag(String agreementcode) {
		 
		 User user1= uRepo.findByUsername1(agreementcode);
		 user1.setFlag("Y");
		  uRepo.save(user1);
	}
	}

	
