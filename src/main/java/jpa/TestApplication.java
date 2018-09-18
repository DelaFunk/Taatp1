package jpa;

import javax.ws.rs.core.Application;

import enties.User;
import services.PlaceService;
import services.UserService;

import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        clazzes.add(UserService.class);
        clazzes.add(PlaceService.class);

        return clazzes;
    }

}
