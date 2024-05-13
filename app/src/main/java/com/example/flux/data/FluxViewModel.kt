package com.example.flux.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.flux.models.Bills
import com.example.flux.models.Budgets
import com.example.flux.models.Expenses
import com.example.flux.navigation.ROUTE_VIEW_BILLS
import com.example.flux.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class FluxViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveBill(
        billCategory: String,
        billAmount: String,
        billDueDate: String,
        billPaymentMode: String
    ) {
        var id = System.currentTimeMillis().toString()
        var billData = Bills(billCategory, billAmount, billDueDate, billPaymentMode, id)
        var billRef = FirebaseDatabase.getInstance().getReference()
            .child("Bills/$id")
        progress.show()
        billRef.setValue(billData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewBill(
        bill: MutableState<Bills>,
        bills: SnapshotStateList<Bills>
    ): SnapshotStateList<Bills> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Bills")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                bills.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Bills::class.java)
                    bill.value = value!!
                    bills.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return bills
    }


    fun deleteBill(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Bills/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Bill deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateBill(category: String, amount: String, date: String, mode:String, id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Bills/$id")
        progress.show()
        var updateData = Bills(category, amount, date, mode, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }



        fun saveBudget(
            budgetCategory: String,
            budgetAmount: String,
            budgetSetDate: String,
            budgetPaymentMode: String
        ) {
            var id = System.currentTimeMillis().toString()
            var budgetData = Budgets(budgetCategory, budgetAmount, budgetSetDate, budgetPaymentMode)
            var budgetRef = FirebaseDatabase.getInstance().getReference()
                .child("Budgets/$id")
            progress.show()
            budgetRef.setValue(budgetData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        fun viewBudget(
            budget: MutableState<Budgets>,
            budgets: SnapshotStateList<Budgets>
        ): SnapshotStateList<Budgets> {
            val ref = FirebaseDatabase.getInstance().getReference().child("Budgets")

            //progress.show()
            ref.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    //progress.dismiss()
                    budgets.clear()
                    for (snap in snapshot.children) {
                        val value = snap.getValue(Budgets::class.java)
                        budget.value = value!!
                        budgets.add(value)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                }
            })
            return budgets
        }


        fun deleteBudget(id: String) {
            var delRef = FirebaseDatabase.getInstance().getReference()
                .child("Budgets/$id")
            progress.show()
            delRef.removeValue().addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context, "Budget deleted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun updateBudget(name: String, quantity: String, price: String, id: String) {
            var updateRef = FirebaseDatabase.getInstance().getReference()
                .child("Budgets/$id")
            progress.show()
            var updateData = Budgets(name, quantity, price, id)
            updateRef.setValue(updateData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    fun saveExpense(
        expenseCategory: String,
        expenseAmount: String,
        expenseDueDate: String,
        expensePaymentMode: String
    ) {
        var id = System.currentTimeMillis().toString()
        var expenseData = Expenses(expenseCategory, expenseAmount, expenseDueDate, expensePaymentMode, id)
        var expenseRef = FirebaseDatabase.getInstance().getReference()
            .child("Expenses/$id")
        progress.show()
        expenseRef.setValue(expenseData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewExpense(
        expense: MutableState<Expenses>,
        expenses: SnapshotStateList<Expenses>
    ): SnapshotStateList<Expenses> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Expenses")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                expenses.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Expenses::class.java)
                    expense.value = value!!
                    expenses.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return expenses
    }

    fun deleteExpense(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Expenses/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Expense deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateExpense(category: String, amount: String, date: String,mode: String, id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Expenses/$id")
        progress.show()
        var updateData = Expenses(category, amount, date, mode, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }















}



