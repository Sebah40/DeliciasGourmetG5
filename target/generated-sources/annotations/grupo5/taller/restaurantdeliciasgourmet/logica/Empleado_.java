package grupo5.taller.restaurantdeliciasgourmet.logica;

import grupo5.taller.restaurantdeliciasgourmet.logica.Rol;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-15T17:36:46", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, Rol> nombre_rol;
    public static volatile SingularAttribute<Empleado, String> correoElectronico;
    public static volatile SingularAttribute<Empleado, String> contraseña;

}