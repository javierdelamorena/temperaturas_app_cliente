var stop;
          function activartemporizar(){
              stop=window.setInterval(graficar2,6000);            
              window.setInterval(buscar,6000);
          }         
          function desactivartemporizador(){
              window.clearInterval(stop);            
          }       	  
               function buscar(){
              
              var url="doMostrarTemperaturas";
              $.get(url,procesarRespuesta);
              
          }
          function borrar(){              
              temp.pop();
              humedades.pop();
              fechas.pop();
              myChart.destroy();             

          }
           
           var temp=[];
           var data=[];
           var humedades=[];
           var fechas= [];         
           var myChart;
              function procesarRespuesta(data){
              
              $.each(data,function(_index,listaString){  
                  
                 
                 temp.push( listaString.temp1 )    ;
                 humedades.push( listaString.humedad );               
                 fechas.push ( listaString.fecha); 
                 console.log(temp )                
                 
             
              });
              
              
              }       
              function graficar2(){ 
                     
              var ctx = document.getElementById('myChart1').getContext('2d');
              myChart1 = new Chart(ctx, {                  
                  type: 'line',
                  data: {
                      labels:fechas,
                      datasets: [               
                          {
                          label: 'Humedad',                        
                          data: humedades,                      
                          }                                                                          
                      ]                      
                  },                 
              });
              console.log(temp);   
          }
    
   