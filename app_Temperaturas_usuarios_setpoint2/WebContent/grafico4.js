var stop;
          function activartemporizar(){
              stop=window.setInterval(graficar4,6000);            
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
              function graficar4(){ 
                     
              var ctx = document.getElementById('myChart4').getContext('2d');
              myChart4 = new Chart(ctx, {                  
                  type: 'line',
                  data: {
                      labels:fechas,
                      datasets: [{
                          label: 'Humedad',                         
                          data: humedades,                                           
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
    
   