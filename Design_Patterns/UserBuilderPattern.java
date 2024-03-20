package Design_Patterns;

public class UserBuilderPattern {

    private String userid;
    private String name;
    private String about;

    

    private UserBuilderPattern(UserBuilder builder){
        this.userid = builder.userid;
        this.name = builder.name;
        this.about = builder.about;
    }

    public UserBuilderPattern() {
    }

    public static UserBuilder Builder(){
        return new UserBuilder();
    }

    public String getUserid() {
        return userid;
    }
    public String getName() {
        return name;
    }
    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "UserBuilderPattern [userid=" + userid + ", name=" + name + ", about=" + about + "]";
    }

    static class UserBuilder{
        private String userid;
        private String name;
        private String about;

        public UserBuilder(){
        }

        public UserBuilder setUserid(String userid) {
            this.userid = userid;
            return this;
        }
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder setAbout(String about) {
            this.about = about;
            return this;
        }

        public UserBuilderPattern build(){
            UserBuilderPattern obj = new UserBuilderPattern(this);
            return obj;
        }
        
    }
    
    
}
