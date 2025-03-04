package baiching.signUpAndSignIn;

import baiching.signUpAndSignIn.models.ERole;
import baiching.signUpAndSignIn.models.Role;
import baiching.signUpAndSignIn.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer {
    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initializeRoles(){
        for (ERole role : ERole.values()) {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(role));
            }
        }
    }
}
