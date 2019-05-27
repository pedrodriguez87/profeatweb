import React from 'react';
import axios from 'axios';
import './App.css';

class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            meals: [],
            user: {
                email: "",
                password: "",
                id: ""
            }
        }
    }

    componentDidMount() {
        const mealsPromise = axios.get("/api/meals");

        mealsPromise.then(response => {
            this.setState({meals: response.data});
            console.log(response.data);
        });
    }

    render() {
        return(
            <div>
                <h1>Profeat App</h1>

                <div>
                    <div>
                        Email: <input className={"email"} onChange={(event) => this.updateField(event, "email")} type="text"/>
                    </div>
                    <div id={"main"}>
                        Password: <input onChange={(event) => this.updateField(event, "password")} type="password"/>
                    </div>
                    <div>
                        <button onClick={() => this.register()}>Sign Up</button>
                    </div>
                    <div>
                        <button onClick={() => this.login()}>Login</button>
                    </div>
                </div>
            </div>
        );
    }

    register() {
        const user = this.state.user;
        console.log("Registering email " + user.email + " with password " + user.password);

        const promise = axios.post("/api/users", user);

        promise.then(response => {
            const message = response.data;
            console.log("Message from registering: " + message);
        })


    }

    login() {
        console.log("inside login")
        const user = this.state.user;
        const promise = axios.post("/api/users/login", user);

        promise.then(response => {
            const validation = response.data;
            let div = document.getElementById("main");
            let p = document.createElement("p");

            let text = "";

            if (validation) {
                text = document.createTextNode("Correct credentials");
                p.className = "correct"
                //console.log("Correct credentials");
            } else {
                text = document.createTextNode("Wrong password or email");
                p.className = "incorrect"
                //console.log("Wrong password or email");
            }

            p.appendChild(text);
            div.appendChild(p);
        })
    }
    updateField(event, property) {
        console.log("input changed");

        const value = event.target.value;

        this.setState((currentState) => {
            currentState.user[property] = value;
            return currentState;
        });

    }
}

export default App;
