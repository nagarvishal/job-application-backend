package app.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.common.entity.UniqueEntity;
import app.common.repository.UniqueReposotiry;

@Component
public class UniqueService {

    @Autowired
    UniqueReposotiry UniqueReposotiry;

    public String generateUniqueNumber(String prefix,String suffix, String id){

            UniqueEntity unique =  this.UniqueReposotiry.findByColumn(id);
            
            System.out.println(unique);
            

            String sequence = Integer.toString(unique.getSequence_no());
            String uniqueSequence = "";
            uniqueSequence = prefix;
            for(int i=0;i<=15-prefix.length()-suffix.length()-sequence.length();i++){
                uniqueSequence = uniqueSequence + "0";
            }
            uniqueSequence = uniqueSequence + sequence;
            uniqueSequence = uniqueSequence + suffix;

            sequence = sequence + 1;

            unique.setSequence_no(unique.getSequence_no()+1);


            this.UniqueReposotiry.save(unique);

            return uniqueSequence;
    }

    public void setUniqueEntiry(UniqueEntity uniqueEntity){

        System.out.println("column=>"+uniqueEntity.getColumn());
        System.out.println("sequence_no=>"+uniqueEntity.getSequence_no());
        this.UniqueReposotiry.save(uniqueEntity);
        return;
        
    }
}
