function selectElement(str, value) {
    let select = document.getElementById(str)
    for (let i = 0; i < select.length; i++) {
        let option = select[i];
        if (option.value === value) {
            option.setAttribute('selected', 'selected')
        } else {
            option.removeAttribute('selected')
        }
    }
}

let myEditDialog = document.getElementById('add_person')
myEditDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget
    let link = button.getAttribute('data-bs-link')
    let pname = button.getAttribute('data-bs-name')
    let page = button.getAttribute('data-bs-age')
    let pcity = button.getAttribute('data-bs-city')
    let pid = button.getAttribute('data-bs-id')
    let hidden = document.getElementById('p_id')
    let name_edit = document.getElementById('p_name')
    let age_edit = document.getElementById('p_age')
    let dialogTitle = myEditDialog.querySelector('.modal-title')
    let approveButton = document.getElementById('approve')
    let form = document.getElementById('add_form')
    form.setAttribute('action', link)

    if (button.getAttribute('data-bs-ident') === '#add') {
        hidden.setAttribute('value', '0')
        name_edit.setAttribute('value', '')
        age_edit.setAttribute('value', '0')
        dialogTitle.textContent = 'Add person'
        approveButton.textContent = 'Add person'
    } else {
        dialogTitle.textContent = 'Edit person'
        approveButton.textContent = 'Update person'
        hidden.setAttribute('value', pid)
        name_edit.setAttribute('value', pname)
        age_edit.setAttribute('value', page)
        selectElement('p_cities_list', pcity);
    }
})

let myConfirmDialog=document.getElementById('myconfirm')
myConfirmDialog.addEventListener('show.bs.modal' , function(event){
    let button = event.relatedTarget
    let link = button.getAttribute('data-bs-link')
    let pid = button.getAttribute('data-bs-id')
    let text = button.getAttribute('data-bs-text')
    let modalTitle = myConfirmDialog.querySelector('.modal-title')
    modalTitle.textContent = 'Delete: ' + text + ' (' + pid + ')'
    let modalText = myConfirmDialog.querySelector('.span-txt')
    modalText.textContent = text + ' (' + pid + ')'
    let deleteButton = myConfirmDialog.querySelector('.delete-button')
    deleteButton.setAttribute('href', link)
})