package dimemtl.com.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dimemtl.com.Model.Meme;
import dimemtl.com.Model.User;
import dimemtl.com.Service.Service;
import io.javalin.http.Context;

public class MemeController extends AuthorizedController<Meme, Integer>{

    private  final Service<User, Integer> userService;

    public MemeController(Service<Meme, Integer> service, ObjectMapper objectMapper, Class<Meme> modelClass, Service<User, Integer> userService) {
        super(service, objectMapper, modelClass);
        this.userService = userService;
    }

    @Override
    public Service<User, Integer> userService() {
        return userService();
    }

    @Override
    boolean isAuthorized(User user, Context context) {
        return false;
    }
}
