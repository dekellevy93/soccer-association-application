package com.SAS.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class TeamOwnerUT {

    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        user = new Registered("avil", "123456", "Avi Levi");
        user = new TeamOwner(user, "Avi Levi");
    }

    @Test
    public void getRole() {
        Assertions.assertEquals("TeamOwner", ((TeamOwner)user).getRole());
    }
}