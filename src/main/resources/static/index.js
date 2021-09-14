function initMap() {
    const myLatLng = { lat: 40, lng: 116.4 };
    const secLatlng = {lat: 39.9, lng: 116.3}
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 16,
        center: myLatLng,
    });

    new google.maps.Marker(
        {
            position: secLatlng,
            map,
            title: "",
        }
    );

    new google.maps.Marker({
        position: myLatLng,
        map,
        title: "Hello World!",
    });
}
