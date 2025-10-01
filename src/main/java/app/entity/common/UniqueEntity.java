package app.entity.common;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "unique")
public class UniqueEntity {

    @NonNull
    private String column;

    @NonNull
    private Integer sequence_no;

    public String getColumn(){
        return this.column;
    }

    public Integer getSequence_no(){
        return this.sequence_no;
    }

    public void setColumn(String column){
        this.column = column;
    }

    public void setSequence_no(Integer sequence_no){
        this.sequence_no = sequence_no;
    }

    

}
