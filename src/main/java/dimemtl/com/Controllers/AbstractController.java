package dimemtl.com.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dimemtl.com.Model.Model;
import dimemtl.com.Service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController<T extends Model<U>, U> implements Controller<T, U> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    private Service<T, U> service;
    private ObjectMapper objectMapper;
    private final Class<T> modelClass;

    public AbstractController(Service<T, U> service, ObjectMapper objectMapper, Class<T> modelClass){
        this.service = service;
        this.objectMapper = objectMapper;
        this.modelClass = modelClass;
    }



}
