document.addEventListener("DOMContentLoaded", function() {
    const loginBtn = document.getElementById("loginBtn");

    loginBtn.addEventListener("click", function() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const role = document.querySelector('input[name="role"]:checked').value;

        const account = {
            userName: username,
            password: password,
            type: parseInt(role)
        };

        fetch('/account/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(account)
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert("Login successful!");
                    // Clear the form
                    document.getElementById("username").value = "";
                    document.getElementById("password").value = "";
                    if (role === "1") {
                        window.location.href = "homePageUser.html";
                    } else {
                        window.location.href = "homePageAdmin.html";
                    }
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});
