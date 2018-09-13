package Servicios;

public class Controller {
    public void eliminar() {
        try {
            Session.beginTransaction();
            Session.getSession().remove(this);
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

    public void persistir() {
        try {
            Session.beginTransaction();
            Session.getSession().persist(this);
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }

    public void actualizar() {
        try {
            Session.beginTransaction();
            Session.getSession().merge(this);
            Session.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            Session.rollbackTransaction();
        }
    }


}
