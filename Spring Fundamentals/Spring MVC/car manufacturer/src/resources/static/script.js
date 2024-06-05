document.addEventListener("DOMContentLoaded", function() {
    const fiatModels = ["Fiat Panda", "Fiat 500", "Fiat 600"];

    const fiatModelsList = document.getElementById("fiatModels");
    fiatModels.forEach(model => {
        const listItem = document.createElement("li");
        listItem.textContent = model;
        fiatModelsList.appendChild(listItem);
    });
});
