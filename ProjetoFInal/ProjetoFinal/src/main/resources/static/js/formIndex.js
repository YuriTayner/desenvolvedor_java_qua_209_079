function abrirForm() {
  document.getElementById("form-overlay").style.display = "grid";
}

function fecharForm() {
  document.getElementById("form-overlay").style.display = "none";
}

const overlay = document.querySelector('#overlay-addEmpresa');
const openBtn = document.querySelector('#openAddEmpresa');
const closeBtn = document.querySelector('#closeAddEmpresa');//

    openBtn.addEventListener("click", () => {
      overlay.style.display = "grid";
    });

    closeBtn.addEventListener("click", () => {
      overlay.style.display = "none";
    });

    // Fechar clicando fora do form
    overlay.addEventListener("click", (e) => {
      if (e.target === overlay) {
        overlay.style.display = "none";
      }
    });