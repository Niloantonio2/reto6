#language: es
#Author: Nilo Chaverra


Característica: E2E start sharp
  Descricion: El usuario puede ingresar a la pagina web con sus credenciales,
  crear unidades de negocios y programar reuniones


  Antecedentes:  inicio de sesion
    Dado que el usuario se encuentra en la pagina
    Cuando ingresa sus credenciales de ingreso
      | strUsuario | strClave  |
      | admin      | serenity  |


   Esquema del escenario: <Escenario>
      Cuando que el usuario crea una unidad de negocio
      Y ingresa los datos
        | strNombreUnidad   | strUnidadPadre   |
        | <strNombreUnidad> | <strUnidadPadre> |
      Entonces se visualizara unidad creada
        | strNombreUnidad   |
        | <strNombreUnidad> |

     Ejemplos:
      | Escenario                       | strNombreUnidad  | strUnidadPadre |
      | Crear unidad de negocio exitoso | Reto 67          | Administration |



  Esquema del escenario: <Escenario>
   Cuando el usuario crea nueva reunion
   | strNombreNegocio   | strUnidadPadre   | strNombreReunion   | intNumeroReunion   | strTipo     | dateFechaInicio   | strHoraInicio   | dateFechaFin    | strHoraFin   | strUbicacion   | strOrganizador  | strReportero   | strAsistentes     |
   | <strNombreNegocio> | <strUnidadPadre> | <strNombreReunion> | <intNumeroReunion> | <strTipo>   | <dateFechaInicio> | <strHoraInicio> | <dateFechaFin>  | <strHoraFin> | <strUbicacion> | <strOrganizador>| <strReportero> | <strAsistentes>   |
   Entonces podra ver creada la reunion
     | strNombreReunion   |
     | <strNombreReunion> |

   Ejemplos:
   | Escenario            | strNombreNegocio | strUnidadPadre  | strNombreReunion | intNumeroReunion | strTipo     | dateFechaInicio | strHoraInicio | dateFechaFin    | strHoraFin | strUbicacion | strOrganizador  | strReportero   | strAsistentes     |
   | Crear reunion exitoso| Reto 6           | Administration  | AutomationTest   | 123456789        | General     | 01/01/2023      | 14:20         | 01/01/2023      | 15:40      | HQ-01        | Aaron Taylor    | Amber Jenkins  | Allison Bell      |





