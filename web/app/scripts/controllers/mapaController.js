
app.controller('mapaController', ['$scope', '$http', function($scope, $http) {
        
        $scope.vectorSource = new ol.source.Vector({
            features: []
        });

        $scope.vectorLayer = new ol.layer.Vector({
            source: $scope.vectorSource
        });

        $scope.rasterLayer = new ol.layer.Tile({
            source: new ol.source.TileJSON({
                url: 'https://api.tiles.mapbox.com/v3/mapbox.geography-class.json?secure',
                crossOrigin: ''
            })
        });

        $scope.map = new ol.Map({
            layers: [$scope.rasterLayer, $scope.vectorLayer],
            target: document.getElementById('map'),
            view: new ol.View({
                center: ol.proj.fromLonLat([2.896372, 44.60240]),
                zoom: 3
            })
        });
        
        $scope.iconStyle = new ol.style.Style({
            image: new ol.style.Icon(({
                color: '#8959A8',
                crossOrigin: 'anonymous',
                src: './app/scripts/lib/marker.png'
            }))
        });
        
        $scope.onMapClick = function(e) {
            console.log('Entro ', e.coordinate);
            
            $scope.punto = {};
            
            $scope.feature = new ol.Feature(
                new ol.geom.Point(e.coordinate)
            );
            $scope.feature.setStyle($scope.iconStyle);
            $scope.vectorSource.addFeature($scope.feature);
            $scope.punto.latitud = e.coordinate[0];
            $scope.punto.longitud = e.coordinate[1];
    
            $http({
                method: "POST",
                url: "http://localhost:8080/Ejemplo_Punto_GIS/Controlador",
                params: $scope.punto

            }).then(function Success(response) {
                $scope.myRes = response.data.myArrayList;
                $scope.statuscode = response.status;

            }, function Error(response) {
                $scope.myRes = response.myArrayList;
                console.log('Error: ', response);
            });
        }

        $scope.map.on('click', $scope.onMapClick);

    }
]); 
