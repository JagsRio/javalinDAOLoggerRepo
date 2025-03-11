package com.jags;
import io.javalin.http.*;
import java.util.List;
import java.util.Objects;

public class OfficeController {
    
    public static Handler fetchAllOffices = ctx -> {
        ClassicModelsImp cm = new ClassicModelsImp();
        List<OfficeModel> offices = cm.GetAllOffices();
        ctx.json(offices);
    };

    public static Handler getOfficeById = ctx -> {
        String id = Objects.requireNonNull(ctx.pathParam("id"));
        ClassicModelsImp cm = new ClassicModelsImp();
        OfficeModel om = cm.GetOfficeById(id);
        ctx.json(om);
    };

}

