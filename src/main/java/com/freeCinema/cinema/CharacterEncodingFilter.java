package com.freeCinema.cinema;

@Bean
public CharacterEncodingFilter charsetFilter() {
   CharsetFilter filter = new CharsetFilter();
   filter.setEncoding("UTF-8");
   filter.setForceEncoding(true);
   FilterRegistrationBean registration = new FilterRegistrationBean(filter);
   registration.addUrlPatterns("/*");
   return registration;
}