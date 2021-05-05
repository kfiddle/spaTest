let header = document.getElementById("subheading");
let button = document.getElementById("greatestButton");
let checkingButton = document.getElementById('checkingIfButton');


header.innerText = "jumaaaaanji";



button.addEventListener("click", () => {
  let comments = document.getElementById("commentBox").value;
  console.log(comments);

  let firstName = document.getElementById("firstName").value;
  console.log(firstName);

  postAPerson(comments);

//   postALongString(comments);
});

function postAPerson(name) {

  fetch("http://localhost:8080/add-person", {
    method: "POST",
    body: name,
  });

  fetch("http://localhost:8080/mail-send", {
  method: "POST",
//   headers: "no-cors",
  body: name,
  })
}

function postALongString(comments) {


}


checkingButton.addEventListener('click', ()=> {
    fetch("http://localhost:8080/all-persons")
    .then((response) => response.json())
    .then((jsonData) => console.log(jsonData));

})