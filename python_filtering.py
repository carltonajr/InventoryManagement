# while True, run the code
while True:
    # Sample beginner query that can be added on to.
    query = "SELECT * FROM company_inventory WHERE "
    # Empty list to store the user inputs in "create_string"
    inputs = []

    # Function that will run 3 times, the number of filters to choose.
    def create_string():
        # Empty string to be filled with at the end of the function
        text = ''

        # run the following script 3 times
        for i in range(3):
            # User Prompt
            print("Enter a number between 0 and 9")
            # User will input text
            user_input = input(f"Number #{i} : ")
            # Show what the user entered.
            print("User Input: {}".format(str(user_input).strip()))
            # If statement to determine whether to add the user input to the 'inputs'
            if str(user_input).strip() != "" and user_input.isnumeric() and 10 < user_input >= 0:
                # If criteria is met add the user input to 'inputs'
                inputs.append(user_input)
                # Add a comma when the length of 'inputs' is more than 0 and less than 4
                if 0 < len(inputs) < 4:
                    inputs.append(", ")
                # Show the current list after comma(s) have been added
                print(inputs)
        # Join the list of inputs with the empty string 'text'.
        return text.join(inputs)
    # Create a complete string that can be used to query the
    final_string = query + create_string()
    # Display inputs
    print("You entered:", final_string)

    # Reset the inputs should the user want to continue the process
    inputs.clear()

    # Ask if the user wants to continue
    again = input("Do you want to enter again? (yes/no): ").strip().lower()
    # Run again if 'yes' or 'y', otherwise end the program.
    if again == 'yes' or again == 'y':
        continue
    else:
        print("Run Complete!")
        break
