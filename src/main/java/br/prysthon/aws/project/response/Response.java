package br.prysthon.aws.project.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    public Long timestamp;
    public Integer status;
    public List<String> erros;
    public T data;

    public Response() {
        this.timestamp = new Date().getTime();
    }
}
