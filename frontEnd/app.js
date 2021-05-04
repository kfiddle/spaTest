
let header = document.getElementById('subheading');

header.innerText = 'jumaaaaanji';


fetch('http://localhost:8080/all-persons')
.then(response => response.json())
.then(jsonData => console.log(jsonData));


