package voiture.model;


import jakarta.persistence.*;

@Entity
@Table(name= "Photo")
public class Photo {

    @Id
    @Column(name = "Id_Photo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id_Photo;

    @Column(name = "nomphoto")
    public byte[] nomphoto;

    @Column(name = "Id_Annonceutilisateur")
    public Integer Id_Annonceutilisateur;

    public Integer getId_Annonceutilisateur() {
        return Id_Annonceutilisateur;
    }

    public void setId_Annonceutilisateur(Integer id_Annonceutilisateur) {
        Id_Annonceutilisateur = id_Annonceutilisateur;
    }

    public int getId_Photo() {
        return Id_Photo;
    }

    public void setId_Photo(int id_Photo) {
        Id_Photo = id_Photo;
    }

    public byte[] getNomphoto() {
        return nomphoto;
    }

    public void setNomphoto(byte[] nomphoto) {
        this.nomphoto = nomphoto;
    }
}
