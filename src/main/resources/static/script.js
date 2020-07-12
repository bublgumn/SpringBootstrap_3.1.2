$('#myModalEdit').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var getId = button.data('editid')
    var getFirstName = button.data('editfirstname')
    var getLastName = button.data('editlastname')
    var getAge = button.data('editage')
    var getEmail = button.data('editemail')

    var modal = $(this)
    modal.find('.editinputid input').val(getId)
    modal.find('.editinputfirstname input').val(getFirstName)
    modal.find('.editinputlastname input').val(getLastName)
    modal.find('.editinputage input').val(getAge)
    modal.find('.editinputemail input').val(getEmail)
});

$('#myModalDelete').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var getId = button.data('deleteid')
    var getFirstName = button.data('deletefirstname')
    var getLastName = button.data('deletelastname')
    var getAge = button.data('deleteage')
    var getEmail = button.data('deleteemail')
    let getRole = button.data('deleterole')

    var modal = $(this)
    modal.find('.deleteinputid input').val(getId)
    modal.find('.deleteinputfirstname input').val(getFirstName)
    modal.find('.deleteinputlastname input').val(getLastName)
    modal.find('.deleteinputage input').val(getAge)
    modal.find('.deleteinputemail input').val(getEmail)
    if (getRole == 2) {
        modal.find('.deleteinputrole option.role0').text('ADMIN')
        modal.find('.deleteinputrole option.role1').text('USER')
    } else {
        modal.find('.deleteinputrole option.role0').text('USER')
        modal.find('.deleteinputrole option.role1').text('')
    }
});
