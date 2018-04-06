package entidades;

/**
 * Created by mimel on 6/04/18.
 */

public class Points {

    private Integer id;
    private String puntos;

    public Points(Integer id, String punto) {
        this.id = id;
        this.puntos= punto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
}
