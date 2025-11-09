package app.form.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.form.entity.Form;
import app.form.repository.FormRepository;

@Component
public class FormService  {
    
    @Autowired
    UniqueService uniqueService;

    @Autowired
    FormRepository formRepository;

    public Object createForm(Form form){
         Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        String formid = uniqueService.generateUniqueNumber("FM", "", "form_id");

        form.setFormId(formid);
        form.setCreatedBy(user_id);
        form.setUpdatedBy(user_id);
        form.setCreatedAt(Instant.now());
        form.setUpdatedAt(Instant.now());

        this.formRepository.save(form);
        
        return null;
    }

}
