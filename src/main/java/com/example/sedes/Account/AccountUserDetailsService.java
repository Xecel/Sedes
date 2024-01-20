package com.example.sedes.Account;import java.util.Optional;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.stereotype.Component;@Componentpublic class AccountUserDetailsService implements UserDetailsService {    private AccountRepository accountRepository;    public AccountUserDetailsService(AccountRepository accountRepository) {        this.accountRepository = accountRepository;    }    @Override    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {        Optional<Account> account = accountRepository.findByUsername(username);        return account.map(AccountUserDetails::new)            .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));    }}