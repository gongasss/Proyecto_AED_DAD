module org.example.proyecto_aed_dad {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;





    opens org.example.proyecto_aed_dad to javafx.fxml;
    opens org.example.proyecto_aed_dad.entity to org.hibernate.orm.core;
    exports org.example.proyecto_aed_dad;
    exports org.example.proyecto_aed_dad.entity;
}
