package app.employeer.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import app.common.service.UniqueService;
import app.employee.entity.User;
import app.employee.service.UserService;
import app.employeer.entity.JobPost;
import app.employeer.repository.JobPostRepository;

@Component
public class JobPostService {

    @Autowired
    UserService userService;

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    UniqueService uniqueService;

 
    public Object createJob(JobPost job){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        String user_id = authentication.getName();

        User user = this.userService.findByUserId(user_id);
        String company_id = user.getCompanyId();
        String job_id = this.uniqueService.generateUniqueNumber("JB","","job_id");

        job.setCompanyId(company_id);
        job.setJobId(job_id);
        job.setCreatedBy(user_id);
        job.setUpdatedAt(Instant.now());
        job.setUpdatedBy(user_id);
        job.setCreatedAt(Instant.now());

        this.jobPostRepository.save(job);
        return null;
    }
    

    


}
