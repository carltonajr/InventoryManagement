while True:
    query = "SELECT * FROM company_inventory WHERE "
    # Collecting user inputs
    inputs = []
    print("Enter a number between 0 and 9")
    def create_string():
        text = ''
        for i in range(3):
            user_input = input(f"Number #{i} : ")
            print("User Input: {}".format(str(user_input).strip()))
            if str(user_input).strip() != "" and user_input.isnumeric():
                inputs.append(user_input)
                if 0 < len(inputs) < 4:
                    inputs.append(", ")
                print(inputs)
        print(text.join(inputs))
        return text.join(inputs)
    final_string = query + create_string()
    # Display inputs
    print("You entered:", final_string)

    # Reset the inputs (not necessary, but shown for clarity)
    inputs.clear()

    # Ask if the user wants to continue
    again = input("Do you want to enter again? (yes/no): ").strip().lower()
    if again == 'yes' or again == 'y':
        continue
    else:
        print("Run Complete!")
        break
