module com.sfs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires javafx.graphics;
    requires java.naming;
    requires org.hibernate.orm.core;

    opens com.sfs to javafx.fxml;
    opens com.sfs.entity to org.hibernate.orm.core;

    exports com.sfs;
}
