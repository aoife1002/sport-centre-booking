document.addEventListener("DOMContentLoaded", function() {
    const registerBtn = document.getElementById("registerBtn");

    registerBtn.addEventListener("click", function() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;
        const type = document.querySelector('input[name="identity"]:checked').value;

        if (password !== confirmPassword) {
            alert("Passwords do not match. Please re-enter.");
            return;
        }

        const account = {
            userName: username,
            password: password,
            type: parseInt(type)
        };

        fetch('/account/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(account)
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert("Registration successful!");
                    window.location.href = "login.html";
                    // 清空表单
                    document.getElementById("username").value = "";
                    document.getElementById("password").value = "";
                    document.getElementById("confirmPassword").value = "";
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});
