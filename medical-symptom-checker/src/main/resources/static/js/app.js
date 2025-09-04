async function checkSymptoms() {
  const symptoms = document.getElementById("symptomsInput").value;
  if (!symptoms) return alert("Please enter symptoms");

  const loaderOverlay = document.getElementById("loaderOverlay");
  const resultsSection = document.getElementById("resultsSection");
  const cardsGrid = document.getElementById("cardsGrid");

  loaderOverlay.style.display = "flex";
  resultsSection.classList.add("hidden");

  try {
    const res = await fetch("/api/check-symptoms", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ symptoms })
    });

    const data = await res.json();

    loaderOverlay.style.display = "none";
    resultsSection.classList.remove("hidden");
    cardsGrid.innerHTML = "";

    data.forEach((result, idx) => {
      cardsGrid.innerHTML += `
        <div onclick="openModal('${result.name}')"
             class="cursor-pointer bg-[#1a1a2e] p-6 rounded-xl shadow-lg hover:scale-105 transition-transform">
          <h2 class="text-lg font-bold">${idx+1}. ${result.name}</h2>
        </div>`;
    });
  } catch (err) {
    loaderOverlay.style.display = "none";
    alert("Error fetching results: " + err);
  }
}

function openModal(name) {
  const modalOverlay = document.getElementById("modalOverlay");
  const modalTitle = document.getElementById("modalTitle");
  const modalReason = document.getElementById("modalReason");

  modalTitle.innerText = name;
  modalReason.innerText = "Fetching detailed explanation...";
  modalOverlay.style.display = "flex";

  fetch("/api/condition-details", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({ condition: name, symptoms: document.getElementById("symptomsInput").value })
  })
    .then(res => res.json())
    .then(detail => {
      modalReason.innerText = detail.reason;
    })
    .catch(err => {
      modalReason.innerText = "Error fetching details: " + err;
    });
}

function closeModal() {
  document.getElementById("modalOverlay").style.display = "none";
}
