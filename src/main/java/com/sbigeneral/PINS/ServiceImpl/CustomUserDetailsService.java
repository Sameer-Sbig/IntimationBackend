//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Fetch user from the database
//        User user = userRepository.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        // Return an instance of UserDetails
//        return new org.springframework.security.core.userdetails.User(
//            user.getUsername(),
//            user.getPassword(),
//            user.getAuthorities()
//        );
//    }
//
//    // Custom method to get additional user details like vendor code
//    public String getVendorCodeByUsername(String username) {
//        User user = userRepository.findByUsername(username);
//        return user != null ? user.getVendorCode() : null;
//    }
//}
//package com;


