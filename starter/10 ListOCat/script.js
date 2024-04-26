window.onload = function() {
    fetch('https://catfact.ninja/facts?limit=50')
        .then(response => response.json())
        .then(data => {
            const factsList = document.getElementById('facts-list');
            data.data.forEach(fact => {
                const listItem = document.createElement('li');
                listItem.textContent = fact.fact;
                listItem.addEventListener('click', () => {
                    window.location.href = '/fact.html?fact=' + encodeURIComponent(fact.fact);
                });
                factsList.appendChild(listItem);
            });
        });
};