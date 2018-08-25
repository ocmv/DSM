<?php
$hostname="localhost";
$database="tareas";
$username="root";
$password="";

$json=array();

    if( isset($_GET["titulo"]) && isset($_GET["descripcion"]) && isset($_GET["area"]))
    {
       
        $titulo=$_GET["titulo"];
        $descripcion=$_GET["descripcion"];
        $area=$_GET["area"];

        $conexion=mysqli_connect($hostname,$username,$password,$database);
        
        $insert="INSERT INTO actividades (id,titulo,descripcion,area) VALUES (null,'{$titulo}','{$descripcion}','{$area}')";
        $resultado_insert=mysqli_query($conexion,$insert);

        if($resultado_insert){
            $consulta="SELECT * FROM actividades WHERE titulo ='{$titulo}'";
           $resultado =mysqli_query($conexion,$consulta);

           if($registro=mysqli_fetch_array($resultado)){
               $json['actividades'][]=$registro;
               echo  json_encode($json);
              
            }

            mysqli_close($conexion);
           
            
        }

        else{
             $resultado['id']=0;
            $resultado['titulo']='No Registra';
            $resultado['descripcion']='No Registra';
            $resultado['area']='No Registra1';
            $json['usuario'][]=$resultado;
            
        }

    }
    else{

        $resultado['id']=0;
        $resultado['titulo']='No Registra';
        $resultado['descripcion']='No Registra';
        $resultado['area']='No Registra2';
        $json['usuario'][]=$resultado;
        
    }




?>