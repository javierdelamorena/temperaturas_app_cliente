 var stop;
          function activartemporizar(){
              stop=window.setInterval(graficar3,6000);            
              window.setInterval(buscar,6000);
          }         
          function desactivartemporizador(){
              window.clearInterval(stop);            
          }       	  
               function buscar(){
              
              var url="doMostrarTemperaturaEntreFechas";
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
                 fechas.push (listaString.fecha); 
                 console.log(temp )                
                 
             
              });
              
              
              }       
              function graficar3(){ 
                     
              var ctx = document.getElementById('myChart3').getContext('2d');
              myChart3 = new Chart(ctx, {                  
                  type: 'line',
                  data: {
                      labels:fechas,
                      datasets: [{
                          label: 'Temperatura',                         
                          data: temp,                                           
	                     } ]                        
	                                               
	                  },                 
	          
					options: {
		                responsive: true,
		                title: {
		                    display: true,
		                    fontColor: "#0B0C0D",
		                    fontSize: 16,
		                    fontFamily: 'Trebuchet MS',
		                    
		                },
		                legend: {
		                    labels: {
		                        fontColor: "black",
		                        fontSize: 15
		                    }
		                },
		                scales: {
		                    yAxes: [{
		                        ticks: {
		                            fontColor: "black",
		                            fontSize: 12,
		                            // stepSize: 1,
		                            // beginAtZero: true
		                        }
		                    }],
		                    xAxes: [{
		                        ticks: {
		                            fontColor: "black",
		                            fontSize: 11,
		                        }
		                    }]
		                }
		            }
		        });
			}
    
   