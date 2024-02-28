function doSubmit() {

    url = "/customer";
    method = "POST";

    document.getElementById("errorDiv").innerHTML = '';
    document.getElementById("resultDiv").innerHTML = '';

    if (document.getElementById("name").value==""){
        alert("No data");
        document.getElementById("name").focus();
        return;
    }

    if (document.getElementById("email").value==""){
        alert("No data");
        document.getElementById("email").focus();
        return;
    }
    if (document.getElementById("registrationDate").value==""){
        alert("No data");
        document.getElementById("registrationDate").focus();
        return;
    }

    var data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        registrationDate: document.getElementById("registrationDate").value
    };

    fetch(url, {
        method: method, // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(data), // body data type must match "Content-Type" header
    })
        .then(res => res.json())
        .then(d => {
            document.getElementById("resultDiv").innerHTML = JSON.stringify(d);
            document.getElementById("resultDiv").innerHTML += "<br>     name= " + d.name + " id= " + d.id;
        })
        .catch(error => {
            if (error instanceof TypeError && error.message.includes('API key')) {
                console.error('Invalid API key:', error);
                document.getElementById("errorDiv").innerHTML = 'Invalid API key:' + error;
            } else {
                console.error('There was a problem with the Fetch operation:', error);
                document.getElementById("errorDiv").innerHTML = 'here was a problem with the Fetch operation:';
            }
        });
}


function updateCustomer(){

    url = "/customer/"+document.getElementById("id").value;
    method = "PUT";

    document.getElementById("errorDiv").innerHTML = '';
    document.getElementById("resultDiv").innerHTML = '';

    if (document.getElementById("name").value==""){
        alert("No data");
        document.getElementById("name").focus();
        return;
    }

    if (document.getElementById("email").value==""){
        alert("No data");
        document.getElementById("email").focus();
        return;
    }
    if (document.getElementById("registrationDate").value==""){
        alert("No data");
        document.getElementById("registrationDate").focus();
        return;
    }

    var data = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        registrationDate: document.getElementById("registrationDate").value
    };

    fetch(url, {
        method: method, // *GET, POST, PUT, DELETE, etc.
        mode: "cors", // no-cors, *cors, same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "same-origin", // include, *same-origin, omit
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: "follow", // manual, *follow, error
        referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(data), // body data type must match "Content-Type" header
    })
        .then(res => res.json())
        .then(d => {
            document.getElementById("resultDiv").innerHTML = JSON.stringify(d);
            document.getElementById("resultDiv").innerHTML += "<br>     name= " + d.name + " id= " + d.id;
        })
        .catch(error => {
            if (error instanceof TypeError && error.message.includes('API key')) {
                console.error('Invalid API key:', error);
                document.getElementById("errorDiv").innerHTML = 'Invalid API key:' + error;
            } else {
                console.error('There was a problem with the Fetch operation:', error);
                document.getElementById("errorDiv").innerHTML = 'here was a problem with the Fetch operation:';
            }
        });
}