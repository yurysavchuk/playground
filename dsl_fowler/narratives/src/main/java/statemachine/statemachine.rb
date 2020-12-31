event :doorClosed, "D1CL"
event :drawerOpened, "D2OP"
event :lightOn, "L1ON"
event :doorOpened, "D1OP",
event :panelClosed, "PNCL"

command :unlockPanel, "PNUL"
command :lockPanel, "PNLK"
command :lockDoor, "D1LK"
command :unlockDoor, "D1UL"

resetEvents :doorOpened

state :idle do
  actions :unlockDoor, :lockPanel
  transitions :doorClosed => :active
end

state :active do
  transitions :drawerOpened => :waitingForLight,
              :lightOn => :waitingForDrawer
end

state :waitingForLight do
  transitions :lightOn => :unlockedPanel
end

state :waitingForDrawer do
  transitions :drawerOpened => :unlockedPanel
end

state :unlockedPanel do
  actions :unlockPanel, :lockDoor
  transitions :panelClosed => :idle
end
