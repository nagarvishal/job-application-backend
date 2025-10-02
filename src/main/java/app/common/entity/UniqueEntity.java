package app.common.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "unique")
public class UniqueEntity {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String column;

    @NonNull
    private Integer sequence_no;

    public ObjectId getId(){
        return id;
    }
    public void setId(ObjectId id){
        this.id = id;
    }

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
