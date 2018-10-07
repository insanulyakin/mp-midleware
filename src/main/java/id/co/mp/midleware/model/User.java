package id.co.mp.midleware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private String email;
    private String password;
    private String nama;
    private String jabatan;
    private String app;

    /**
     * list user
     *
     * @param id
     * @param email
     * @param nama
     * @param jabatan
     * @param app
     */
    public User(Integer id, String email, String nama, String jabatan, String app) {
        this.setId(id);
        this.setEmail(email);
        this.setNama(nama);
        this.setJabatan(jabatan);
        this.setApp(app);
    }
}
