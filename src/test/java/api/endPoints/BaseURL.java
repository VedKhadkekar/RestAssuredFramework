package api.endPoints;

public class BaseURL {

    /*
    Swagger URI : https://petstore.swagger.io/v2
    User Module
    Create User : https://petstore.swagger.io/v2/user
    get User  : https://petstore.swagger.io/v2/user/{username}
    update user : https://petstore.swagger.io/v2/user/{username}
    delete user : https://petstore.swagger.io/v2/user/{username}
    */

    public static String base_url = "https://petstore.swagger.io/v2";
    // User Module
    public  static String create_user = base_url+"/user";
    public  static String get_user = base_url+"/user/{username}";
    public  static String update_user = base_url+"/user/{username}";
    public  static String delete_user = base_url+"/user/{username}";

    //store Module URL's
    // pet Module  URL's


}
