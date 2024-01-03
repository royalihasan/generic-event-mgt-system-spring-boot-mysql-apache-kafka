package alpha1.o.com.genericeventmgtsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    public String message;
    public  Boolean success;
}
