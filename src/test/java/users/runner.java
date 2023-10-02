package users;

import com.intuit.karate.junit5.Karate;

public class runner {
    @Karate.Test
    Karate userGet(){ return Karate.run("users").relativeTo(getClass());
    }
}


