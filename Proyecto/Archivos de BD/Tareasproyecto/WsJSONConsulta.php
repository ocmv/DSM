<?php
$hostname="localhost";
$database="tareas";
$username="root";
$password="";

$json=array();

    if( isset($_GET["area"]))
    {
       
       
        $area=$_GET["area"];

        $conexion=mysqli_connect($hostname,$username,$password,$database);
        
        
            $consulta="SELECT id,titulo,descripcion FROM actividades WHERE area ='{$area}'";
           $resultado =mysqli_query($conexion,$consulta);

           while($registro=mysqli_fetch_array($resultado)){
        
			$json['actividades'][]=$registro;
			//echo $registro['id'].' - '.$registro['nombre'].'<br/>';
		}
           
       

       
        mysqli_close($conexion);
        echo json_encode($json);
    }

    
    else{

        $resultado['id']=0;
        $resultado['titulo']='No Registra';
        $resultado['descripcion']='No Registra';
        $resultado['area']='No Registra2';
        $json['actividades'][]=$resultado;
        
    }




?>