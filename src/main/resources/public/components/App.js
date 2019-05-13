class App extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            users: [],
            user: {
                email: "",
                password: "",
                id: ""
            }
        }
    }

    componentDidMount() {
        const mealsPromise = axios.get("/api/users");

        mealsPromise.then(response => {
            this.setState({users: response.data});
            console.log(response.data);
        });
    }

    render() {
        return(
            <div>
            <h1>Profeat App</h1>

        <div>
        <div>
        Email: <input onChange={(event) => this.updateField(event, "email")} type="text"/>
            </div>
            <div>
            Password: <input onChange={(event) => this.updateField(event, "password")} type="password"/>
            </div>
            <div>
            <button onClick={() => this.register()}>Sign Up</button>
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

    updateField(event, property) {
        console.log("input changed");

        const value = event.target.value;

        this.setState((currentState) => {
            currentState.user[property] = value;
            return currentState;
        });

    }
}