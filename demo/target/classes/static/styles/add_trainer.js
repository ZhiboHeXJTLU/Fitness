document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("trainerForm");
    const submitButton = document.getElementById("submitButton");
    const cancelButton = document.getElementById("cancelButton");

    submitButton.addEventListener("click", function() {
        event.preventDefault();
        submitForm();
    });

    cancelButton.addEventListener("click", function() {
        window.location.href = '/add_trainer';
    });

    function submitForm() {
        const name = document.getElementById("name").value;
        const sex = document.getElementById("sex").value;
        const honour = document.getElementById("honour").value;
        const experience = document.getElementById("experience").value;
        const entryTime = document.getElementById("entry-time").value; // Changed to entry-time

        // Send form data to server using fetch
        fetch("/add_trainer", {
            method: "POST",
            body: JSON.stringify({ name, sex, honour, experience, entryTime }), // Changed to entryTime
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error("Failed to add trainer.");
            }
        }).then(data => {
            alert(data); // Display success message or handle response data
        }).catch(error => {
            console.error("Error:", error);
        });
    }
});
